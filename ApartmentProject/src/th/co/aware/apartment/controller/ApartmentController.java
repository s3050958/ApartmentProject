package th.co.aware.apartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import th.co.aware.apartment.DAO.InvDAO;
import th.co.aware.apartment.DAO.InvoiceDAO;
import th.co.aware.apartment.DAO.RoomDAO;
import th.co.aware.apartment.DAO.userDAO;
import th.co.aware.apartment.bean.Invoice;
import th.co.aware.apartment.bean.Room;
import th.co.aware.apartment.bean.User;
import th.co.aware.apartment.login.LoginValidation;

@Controller
public class ApartmentController {

	@Autowired
	userDAO userdao;
	@Autowired
	RoomDAO roomdao;
	// @Autowired
	// InvDAO invoicedao;
	@Autowired
	InvoiceDAO invoicedao;

	////////////////////////////////////////////////////// Login///////////////////////////////////////////
	@RequestMapping("")
	public String login(ModelMap model) {
		model.addAttribute("login", new User());
		return "login";
	}
	
	@RequestMapping("logOut")
	public String logOut(ModelMap model) {
	//	model.addAttribute("login", new User());
		return "redirect:/";
	}

	@RequestMapping("doLogin")
	public String doLogin(@ModelAttribute("addUser") User User, ModelMap model) {
		LoginValidation loginValidate = new LoginValidation();
		int loginResult = loginValidate.validate(User.getUsername(), User.getPassword());

		if (loginResult == 1) {
			// ModelAndView view = new ModelAndView("addUser");
			// model.addAttribute("newUser", new User());
			return "showOption";
		} else if (loginResult == 2) {
			// ModelAndView view = new ModelAndView("showUser");
			// model.addAttribute("showUser", new User());
			return "redirect:/showUser";
		} else {
			// ModelAndView view = new ModelAndView("login");
			// model.addAttribute("login", new User());
			return "redirect:/";
		}
		


	}
	///////////////////////////////////////////////// End
	///////////////////////////////////////////////// Login///////////////////////////////////////////

	///////////////////////////////////////////////// User////////////////////////////////////////////////

	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam int id, Model data) {

		User u = userdao.getUserByIdRowMapper(id);

		roomdao.updateRoomStatusG(u);

		userdao.deleteUser(u);
		return "redirect:/showUser";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam int id, ModelMap model) {

		User u = userdao.getUserByIdRowMapper(id);
		
		userdao.userChangeUrid(u);
		
		List<Room> room = roomdao.getAvaliableRoomRowMapper();
		model.addAttribute("room", room);

		userdao.userChangeRoom(u);
		// roomdao.updateRoomStatusR(u);
		roomdao.updateRoomStatusG(u);
		return new ModelAndView("editUser", "editUser", u);
	}

	@RequestMapping("/doEditUser")
	public ModelAndView doEditUser(@ModelAttribute User u,ModelMap model) {

		
		roomdao.updateRoomStatusG(u);

		userdao.userChangeRoom(u);
		userdao.userChangeUrid(u);

		roomdao.updateRoomStatusR(u);

		return new ModelAndView("redirect:/showUser");
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user(Model model) {
		List<Room> room = roomdao.getAvaliableRoomRowMapper();
		model.addAttribute("room", room);
		return new ModelAndView("addUser", "addUser", new User());
	}

	@RequestMapping("showUser")
	public String showUser(ModelMap model) {
		List<User> user = userdao.getAllUserRowMapper();
		model.addAttribute("showUser", user);
		return "showUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("SpringWeb_") User user, ModelMap model) {

		List<User> userList = userdao.getIdUserRowMapper(user.getR_id());
		List<Room> room = roomdao.getAvaliableRoomRowMapper();

		if (userList.size() == 1) {
			return new ModelAndView("redirect:/cantadd");
		} else {

			model.addAttribute("room", room);
			// roomdao.updateRoomStatusG(user);
			userdao.saveUserByPreparedStatement(user);
			// userdao.userChangeUrid(user);
			User u = userdao.getLastUserId(user);
			userdao.userChangeUrid(u);
			roomdao.updateRoomStatusR(u);

			return new ModelAndView("redirect:/showUser");
		}
	}

	@RequestMapping(value = "cantadd", method = RequestMethod.GET)
	public ModelAndView cant() {
		return new ModelAndView("cantAddUser", "addUser", new User());

	}

	//////////////////////////////////////////////// End User
	//////////////////////////////////////////////// ////////////////////////////////////////////

	//////////////////////////////////////////// ROOM
	//////////////////////////////////////////// ////////////////////////////////////////////////////

	@RequestMapping("/doEditRoom")
	public ModelAndView doEditRoom(@ModelAttribute Room u) {

		roomdao.updateLAndWtatus(u);

		return new ModelAndView("redirect:/showRoom");
	}

	@RequestMapping(value = "/editRoom", method = RequestMethod.GET)
	public ModelAndView editRoom(@RequestParam int id) {

		Room r = roomdao.getRoomByIdRowMapper(id);

		return new ModelAndView("editRoom", "editRoom", r);
	}

	@RequestMapping("/confirmInvoice")
	public String confirmInvoice(@RequestParam int id, Model data) {

		Room r = roomdao.getRoomByIdRowMapper(id);

		roomdao.updateRoomStatus0(r);

		invoicedao.saveInvoiceByPreparedStatement(r);

		return "redirect:/showInvoice";
	}

	@RequestMapping("showRoom")
	public String showRoom(ModelMap model) {
		List<Room> room = roomdao.getAllRoomRowMapper();
		model.addAttribute("showRoom", room);
		return "showRoom";
	}

	//////////////////////////////////////// End Room
	//////////////////////////////////////// ////////////////////////////////////////////////////////

	/////////////////////////////////////// Invoice
	/////////////////////////////////////// /////////////////////////////////////////////////////////

	@RequestMapping("showInvoice")
	public String showInvoice(ModelMap model) {
		List<Invoice> Invoice = invoicedao.getAllInvoiceRowMapper();
		model.addAttribute("showInvoice", Invoice);
		return "showInvoice";
	}

	@RequestMapping("/paid")
	public String paid(@RequestParam int id, Model data) {

		Invoice r = invoicedao.getInvoiceByIdRowMapper(id);

		invoicedao.updatePaidStatusG(r);

		return "redirect:/showInvoice";
	}

	//////////////////////////////////////////// End Invoice
	//////////////////////////////////////////// //////////////////////////////////////////
}
