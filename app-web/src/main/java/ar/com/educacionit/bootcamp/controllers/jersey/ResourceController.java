package ar.com.educacionit.bootcamp.controllers.jersey;

import java.io.IOException;

import ar.com.educacionit.bootcamp.controllers.jersey.dto.ReqResUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@WebServlet("/users")
public class ResourceController extends HttpServlet {

	private static final long serialVersionUID = 6233410081275428842L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//url del servicio
		String url = "https://reqres.in/api";
		//id viene porparametro
		String id = req.getParameter("id");
		String endPoint = "/users/" + id;
		
		//crear el cliente jersey para hacer la peticion http
		//convertir los datos
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target(url).path(endPoint);
		
		Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
		
		//metodo get-post
		Response response = invocation.get();
		
		if(response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
		}
		ReqResUser user = response.readEntity(ReqResUser.class);

		resp.getWriter().print(user);
		
	}
}
