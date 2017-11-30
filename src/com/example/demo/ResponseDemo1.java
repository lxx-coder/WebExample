package com.example.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 4312868947607181532L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		outputChineseByOutputStream(resp);//使用OutputStream流输出中文
	}
	
	/**
	 * 使用OutputStream流输出中文
	 * @param response
	 * @throws IOException
	 */
	
	public void outputChineseByOutputStream(HttpServletResponse response)throws IOException{
		/**
		 *使用OutputStream输出中文注意问题
		 *在服务器端，数据是以哪个码表输出的，那么就要控制客户端浏览器以相应的码表打开，
		 *例如：outputStream。write("中国".getBytes("UTF-8"));//以UTF-8编码使用OutputStream流向客户端输出中文，
		 *就要以UTF-8格式打开浏览器，否则就会出现中文乱码
		 *可以通过设置头控制浏览器的行为，
		 *response.setHeader("content-type","text/html;charset=UTF-8")
		 */
		String data = "中国";
		OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		/**
		 * data.getBytes()是一个将字符串转换为字节数组的过程，这个过程一定回去查码表
		 * 如果是中文的操作系统环境，默认就是查找查GB2312的码表，
		 * 将字符转换成字节数组的过程就是将中文字符转换成GB2312的码表上对应的数字
		 * 比如： "中"在GB2312的码表上对应的数字是98，"国"在GB2312的码表上对应的数字是99
		 * getBytes()方法如果不带参数，那么就会根据操作系统的语言环境来选择转换码表，如果是中文操作系统，那么就使用GB2312的码表
		 */
		byte[] dataByteArr = data.getBytes("UTF-8");
		outputStream.write(dataByteArr);		
	}
	
	public void outputChinesePrintWriter(HttpServletResponse response)throws IOException{
		String data = "中国";
		
		//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
		//response.setHeader("content-type", "text/html;charset=UTF-8");
		
//		response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
		/**
         * PrintWriter out = response.getWriter();这句代码必须放在response.setCharacterEncoding("UTF-8");之后
         * 否则response.setCharacterEncoding("UTF-8")这行代码的设置将无效，浏览器显示的时候还是乱码
         */
        PrintWriter out = response.getWriter();//获取PrintWriter输出流
        
        /**
         * 多学一招：使用HTML语言里面的<meta>标签来控制浏览器行为，模拟通过设置响应头控制浏览器行为
         * out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
         * 等同于response.setHeader("content-type", "text/html;charset=UTF-8");
         */
        out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
        out.write(data);//使用PrintWriter流向客户端输出字符
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
//		doGet(req, resp);
	}

}
