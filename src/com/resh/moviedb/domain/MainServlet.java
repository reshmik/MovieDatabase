package com.resh.moviedb.domain;

 import java.io.IOException;
 import java.io.PrintWriter;
 import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 public class MainServlet extends HttpServlet 
{
     private static final long serialVersionUID = 1L;
     MovieDatabase movie = new MovieDatabase();
     MovieDatabaseProxy store = new MovieDatabaseProxy();
     public MainServlet() 
      {
         super();   
         
      }
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
      {
         doGet(request, response);
       }
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
      {
         response.setContentType("text/html");
         PrintWriter out=response.getWriter();
//         out.println("<html><head>");
//         out.println("<title>Servlet Parameter</title>");
//         out.println("</head>");
//         out.println("<body>");
         Movie newMovie=null;
         String titleText = request.getParameter("name");
         System.out.println("***titleText***"+titleText);
         if(movie.retrieve(titleText)== null){
         newMovie = store.retrieveAndStore(titleText);
         }
         System.out.println("**"+newMovie.getTitle());
         
         request.setAttribute("title",newMovie.getTitle());
         request.setAttribute("genre",newMovie.getGenres());
         request.setAttribute("date",newMovie.getReleaseDate());
         request.setAttribute("poster", newMovie.getPoster());
//         RequestDispatcher rd = request.getRequestDispatcher("/movie.html");
//         rd.forward(request, response);
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/movie.jsp");
		  dispatcher.forward(request,response);
//         Enumeration parameters = request.getParameterNames();
//         String param=null;
//             while (parameters.hasMoreElements())
//             {
//                   param=(String)parameters.nextElement();                  
//                  out.println(param + ":" + request.getParameter(param) + "<br>" );                  
//            }
//        out.println("</body></html>");
        out.close();
       }
 }
