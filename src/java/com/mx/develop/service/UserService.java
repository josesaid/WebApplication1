package com.mx.develop.service;

import com.mx.develop.dao.UserDao;
import com.mx.develop.pojo.User;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author said.olano@oracle.com
 */

@Path("/UserService")
public class UserService {
   UserDao userDao = new UserDao();
   
   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public List<User> getUsers(){
      return userDao.getAllUsers();
   }	
   
}