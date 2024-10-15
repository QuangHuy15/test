package vniot.star.controllers.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vniot.star.ultils.Constant;

@WebServlet(urlPatterns = {"/image"})
public class DownloadFileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fname"); // Get file name from request
        File file = new File(Constant.DIR + "/" + fileName); // Create file object

        resp.setContentType("image/jpeg"); // Set response content type

        if (file.exists()) {
            IOUtils.copy(new FileInputStream(file), resp.getOutputStream()); // Copy file to output stream
        }
	}
}
