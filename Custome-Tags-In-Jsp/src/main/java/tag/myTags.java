package tag;

import java.util.Date;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class myTags extends TagSupport {

	@Override
	public int doStartTag() throws JspException {

		try {

			JspWriter out = pageContext.getOut();
			out.println("<h1>This is a custome Tags</h1>");
			out.println("<p>this is custome paragarah</p>");
			out.println("<br>");
			out.println(new Date().toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;

	}
}
