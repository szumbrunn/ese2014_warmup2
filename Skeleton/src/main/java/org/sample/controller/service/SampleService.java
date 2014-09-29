package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.CreateTeam;
import org.sample.controller.pojos.SignupForm;

public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

	public CreateTeam saveFrom(CreateTeam createTeam);

	public Object getTeamList();

	public Object getUser(Long id);
	
	public Object getUserTeam(Long userid);
	
	public Object getUserIdByFirstName(String name);

}
