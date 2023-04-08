package Entities;

import java.sql.Date;

public class Episode {
private String synopsis;
private  Date Date_diffusion;
public Episode(String synopsis, Date date_diffusion) {
	super();
	this.synopsis = synopsis;
	Date_diffusion = date_diffusion;
}
}
