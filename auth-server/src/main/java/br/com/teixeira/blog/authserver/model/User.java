package br.com.teixeira.blog.authserver.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	private String emailAddress;
	private String firstName;
	private String lastName;
	private Integer age;
	private String password;
	private Boolean verified = false;
	private boolean enabled = true;
	// private List<Role> roles = new ArrayList<Role>();

	public User() {
		super();
	}

//	private void deSerializeRoles(List<String> roles) {
//		for (String role : roles) {
//			this.addRole(Role.valueOf(role));
//		}
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//		for (Role role : this.getRoles()) {
//			GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
//			authorities.add(authority);
//		}
//		return authorities;
//	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean isVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public String getHashedPassword() {
		return password;
	}

	public void setHashedPassword(String hashedPassword) {
		this.password = hashedPassword;
	}

	// public List<Role> getRoles() {
	// return Collections.unmodifiableList(this.roles);
	// }
	//
	// public void addRole(Role role) {
	// this.roles.add(role);
	// }
	//
	// public boolean hasRole(Role role) {
	// return (this.roles.contains(role));
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
