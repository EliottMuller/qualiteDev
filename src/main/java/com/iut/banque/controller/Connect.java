package com.iut.banque.controller;

import java.util.Map;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import com.iut.banque.constants.LoginConstants;
import com.iut.banque.facade.BanqueFacade;
import com.iut.banque.modele.Client;
import com.iut.banque.modele.Compte;
import com.iut.banque.modele.Utilisateur;

public class Connect extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String userCde;
	private String userPwd;
	private BanqueFacade banque;
	private static final Logger LOGGER = Logger.getLogger(Connect.class.toString());

	/**
	 * Constructeur de la classe Connect
	 * 
	 * @return Un objet de type Connect avec façade BanqueFacade provenant de sa
	 *         factory
	 */
	public Connect() {
		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		this.banque = (BanqueFacade) context.getBean("banqueFacade");

	}

	/**
	 * Méthode pour vérifier la connexion de l'utilisateur basé sur les
	 * paramêtres userCde et userPwd de cette classe
	 * 
	 * @return String, le resultat du login; "SUCCESS" si réussi, "ERROR" si
	 *         échec
	 */
	public String login() {
		if (userCde == null || userPwd == null) {
			return "ERROR";
		}
		userCde = userCde.trim();

		int loginResult;
		try {
			loginResult = banque.tryLogin(userCde, userPwd);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "erreur lors de la connection ",e);
			loginResult = LoginConstants.ERROR;
		}

		switch (loginResult) {
		case LoginConstants.USER_IS_CONNECTED:
			return "SUCCESS";
		case LoginConstants.MANAGER_IS_CONNECTED:
			return "SUCCESSMANAGER";
		case LoginConstants.LOGIN_FAILED:
			return "ERROR";
		default:
			return "ERROR";
		}
	}

	/**
	 * Getter du champ userCde
	 * 
	 * @return String, le userCde de la classe
	 */
	public String getUserCde() {
		return userCde;
	}

	/**
	 * Setter du champ userCde
	 * 
	 * @param userCde
	 *            : String correspondant au userCode à établir
	 */
	public void setUserCde(String userCde) {
		this.userCde = userCde;
	}

	/**
	 * Getter du champ userPwd
	 * 
	 * @return String, le userPwd de la classe
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * Setter du champ userPwd
	 * 
	 * @param userPwd
	 *            : correspondant au pwdCde à établir
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * Getter du champ utilisateur (uilisé pour récupérer l'utilisateur
	 * actuellement connecté à l'application)
	 * 
	 * @return Utilisateur, l'utilisateur de la classe
	 */
	public Utilisateur getConnectedUser() {
		return banque.getConnectedUser();
	}

	/**
	 * Méthode qui va récupérer sous forme de map la liste des comptes du client
	 * actuellement connecté à l'application
	 * 
	 * @return Map<String, Compte> correspondant à l'ID du compte et l'objet
	 *         Compte associé
	 */
	public Map<String, Compte> getAccounts() {
		return ((Client) banque.getConnectedUser()).getAccounts();
	}

	public String logout() {
		banque.logout();
		return "SUCCESS";
	}

}
