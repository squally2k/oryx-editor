package de.hpi.yawl.resourcing;

import java.util.ArrayList;

public class OrgData implements FileWritingForYAWL {

	ArrayList<Participant> participants = new ArrayList<Participant>();
	ArrayList<Role> roles = new ArrayList<Role>();
	ArrayList<Position> positions = new ArrayList<Position>();
	ArrayList<Capability> capabilities = new ArrayList<Capability>();
	ArrayList<OrgGroup> orgGroups = new ArrayList<OrgGroup>();
	
	public OrgData() {
		super();
	}

	public ArrayList<Participant> getParticipants() {
		return participants;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public ArrayList<Position> getPositions() {
		return positions;
	}

	public ArrayList<Capability> getCapabilities() {
		return capabilities;
	}

	public ArrayList<OrgGroup> getOrgGroups() {
		return orgGroups;
	}

	public String writeToYAWL(){
		String s = "";
		s += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		s += "<orgdata>\n";
		
		if(participants.isEmpty())
	    	s += "\t<participants />\n";
	    else{
	    	s += "\t<participants>\n";
	    	for (Participant participant : participants){
	    		s += participant.writeToYAWL();
	    	}
	    	s += "\t</participants>\n";
	    }
		
		if(roles.isEmpty())
	    	s += "\t<roles />\n";
	    else{
	    	s += "\t<roles>\n";
	    	for (Role role : roles){
	    		s += role.writeToYAWL();
	    	}
	    	s += "\t</roles>\n";
	    }
		
		if(positions.isEmpty())
	    	s += "\t<positions />\n";
	    else{
	    	s += "\t<positions>\n";
	    	for (Position position : positions){
	    		s += position.writeToYAWL();
	    	}
	    	s += "\t</positions>\n";
	    }
		
		if(orgGroups.isEmpty())
	    	s += "\t<orggroups />\n";
	    else{
	    	s += "\t<orggroups>\n";
	    	for (OrgGroup orgGroup : orgGroups){
	    		s += orgGroup.writeToYAWL();
	    	}
	    	s += "\t</orggroups>\n";
	    }
		
		s += "</orgdata>";
		
		return s;
	}
}
