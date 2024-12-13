package tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class PrintTableTag extends TagSupport {

	public int number;

	// setter
	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int doStartTag() throws JspException {

		try {
			JspWriter out = pageContext.getOut();
			// print table

			// 1-10 loop

			out.println("<br>");
			for (int i = 1; i <= 10; i++) {
				out.println((i * number) + "<br>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}
}