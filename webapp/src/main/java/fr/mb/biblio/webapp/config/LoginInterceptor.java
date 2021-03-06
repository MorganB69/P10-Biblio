package fr.mb.biblio.webapp.config;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import fr.mb.biblio.webappConsumer.services.identification.Utilisateur;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * Interceptor pour s'authentifier avant d'accéder à certaines pages
 * @author Morgan
 *
 */
public class LoginInterceptor implements Interceptor, SessionAware {


	/**
	 *Objet de session 
	 */
	private Map<String, Object> session;


	@Override
	public void destroy() {
		//release resources here
	}

	@Override
	public void init() {
		// create resources here
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation)
			throws Exception {

		final ActionContext context = actionInvocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		
		
		String actionName = actionInvocation.getInvocationContext().getName();

		HttpServletRequest request = (HttpServletRequest)context.get(StrutsStatics.HTTP_REQUEST);

		String url = String.valueOf(request.getRequestURL());
		String queryString = request.getQueryString();
		String fullUrl = url + (queryString==null ? "" : ("?" + queryString));


		
		
		
		if (!"login".equalsIgnoreCase(actionName)) {
		    session.put("lastAction", actionName);
		    session.put("url", fullUrl);

		}
		

		
		Utilisateur user = (Utilisateur) session.get("user");
		

		
		if(user == null){
			return "loginUser";
		}
		else{
				

			return actionInvocation.invoke();
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	


}