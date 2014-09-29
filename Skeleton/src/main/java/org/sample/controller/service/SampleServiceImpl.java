package org.sample.controller.service;

import java.util.Date;
import java.util.List;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.CreateTeam;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.Address;
import org.sample.model.Team;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.TeamDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    @Autowired	  TeamDao teamDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }


        Address address = new Address();
        address.setStreet("TestStreet-foo");
        
        
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        
        Team team = null;
        
        for(Team t : teamDao.findAll())
        {
        	if(t.getId().toString().equals(signupForm.getSelectedTeam()))
        		team = t;
        }
        
       // System.out.println("team: " + signupForm.getSelectedTeam() + "teamname: " + team.getTeamName());
        
        user.setTeam(team);
        
        user = userDao.save(user);   // save object to DB
        
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());

        return signupForm;

    }
    
    @Transactional
    public Object getUser(Long id)
    {
    	User user = userDao.findOne(id);
    	return user;
    }
    
    @Transactional
    public CreateTeam saveFrom(CreateTeam createTeam) throws InvalidUserException{
    	
    	String teamName = createTeam.getTeamName();
    	
    	if(!StringUtils.isEmpty(teamName) && "ESE".equalsIgnoreCase(teamName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }
    	
    	 Team team = new Team();
         team.setTeamName(createTeam.getTeamName());
         team.setDate(new Date());
         
         team = teamDao.save(team);   // save object to DB
         
         return createTeam;
    }
    
    @ModelAttribute("Team")
    public Object getTeamList()
    {
    	Iterable<Team> teams = teamDao.findAll();
    	return teams;
    }

	public Object getUserTeam(Long userid) {
		
		User user = userDao.findOne(userid);
		
		return user.getTeam();
	}

	public Object getUserIdByFirstName(String name) {
		
		for(User u : userDao.findAll())
		{
			if(u.equals(name))
			{
				return u.getId();
			}
		}
		
		return null;
	}

}
