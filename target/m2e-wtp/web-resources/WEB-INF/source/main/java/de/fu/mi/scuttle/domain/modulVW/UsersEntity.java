package de.fu.mi.scuttle.domain.modulVW;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="modulverwaltung1_users")
public class UsersEntity {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uu_id")
	@Id
	private long id;
	
	@Column(name="u_name",unique = true,nullable=false)
	private String uname;
	
	@Column(name="u_pwd")
	private String pwd;
	
	/*@OneToOne(mappedBy="user", targetEntity=UserRolesEntity.class, fetch=FetchType.LAZY)
	List<UserRolesEntity> roles;*/
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="user")
	private UserRolesEntity userrole;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {		
		this.pwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
	}
	
	public boolean checkPwd(String pwd){
		return BCrypt.checkpw(pwd, getPwd());
	}

	public UserRolesEntity getUserrole() {
		return userrole;
	}

	public void setUserrole(UserRolesEntity userrole) {
		this.userrole = userrole;
	}

}
