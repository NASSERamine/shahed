package Entities;


public class Role {
private String Type;
private boolean nom_tvShow;
private Boolean Full_show;
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public boolean isNom_tvShow() {
	return nom_tvShow;
}
public void setNom_tvShow(boolean nom_tvShow) {
	this.nom_tvShow = nom_tvShow;
}
public Boolean getFull_show() {
	return Full_show;
}
public void setFull_show(Boolean full_show) {
	Full_show = full_show;
}
public Role(String type, boolean nom_tvShow, Boolean full_show) {
	super();
	Type = type;
	this.nom_tvShow = nom_tvShow;
	Full_show = full_show;
}

}