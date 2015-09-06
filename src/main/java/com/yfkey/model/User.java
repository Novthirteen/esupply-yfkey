package com.yfkey.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * This class represents the basic "user" object in AppFuse that allows for
 * authentication and user management. It implements Acegi Security's
 * UserDetails interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Updated by
 *         Dan Kibler (dan@getrolling.com) Extended to implement Acegi
 *         UserDetails interface by David Carter david@carter.net
 */
@Entity
@Table(name = "user")
@XmlRootElement(name = "User")
public class User extends BaseObject implements Serializable, UserDetails, Auditable, Versionable {
	private static final long serialVersionUID = 3832626162173359411L;

	private String username; // required
	private String password; // required
	private String confirmPassword;
	private String passwordHint;
	private String firstName; // required
	private String lastName; // required
	private String email; // required; unique
	private String phoneNumber;
	private String website;
	private Gender gender;
	private String mobilephone;
	private String language;
	private Address address = new Address();
	private int version;
	private boolean enabled;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
	private String createUser;
	private Timestamp createDate;
	private String updateUser;
	private Timestamp updateDate;
	private Collection<UserAuthority> userAuthorizedUrls;
	private Collection<UserMenu> userMenus;
	private Collection<UserAuthority> userAuthorizedPlants;
	private Collection<UserAuthority> userAuthorizedSuppliers;
	private Collection<UserAuthority> userAuthorizedButtons;

	/**
	 * Default constructor - creates a new instance with no values set.
	 */
	public User() {
	}

	/**
	 * Create a new instance and set the username.
	 *
	 * @param username
	 *            login name for user.
	 */
	public User(final String username) {
		this.username = username;
	}

	@Id
	@Column(length = 50)
	public String getUsername() {
		return username;
	}

	@Column(nullable = false)
	@XmlTransient
	public String getPassword() {
		return password;
	}

	@Transient
	@XmlTransient
	public String getConfirmPassword() {
		return confirmPassword;
	}

	@Column(name = "password_hint")
	@XmlTransient
	public String getPasswordHint() {
		return passwordHint;
	}

	@Column(name = "first_name", nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "last_name", nullable = false, length = 50)
	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public String getLanguage() {
		return language;
	}

	/**
	 * Returns the full name.
	 *
	 * @return firstName + ' ' + lastName
	 */
	@Transient
	public String getFullName() {
		return firstName + ' ' + lastName;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	/**
	 * @return GrantedAuthority[] an array of roles.
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Transient
	@JsonIgnore
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
		authorities.addAll(this.userAuthorizedUrls);
		return authorities;
	}

	@Transient
	@JsonIgnore
	public Collection<UserAuthority> getAuthoriedPlants() {
		return this.userAuthorizedPlants;
	}

	@Transient
	@JsonIgnore
	public Collection<UserAuthority> getAuthoriedSuppliers() {
		return this.userAuthorizedSuppliers;
	}

	@Transient
	@JsonIgnore
	public Collection<UserAuthority> getAuthoriedButtons() {
		return this.userAuthorizedButtons;
	}

	@Version
	public int getVersion() {
		return version;
	}

	@Column(name = "account_enabled")
	public boolean isEnabled() {
		return enabled;
	}

	@Column(name = "account_expired", nullable = false)
	public boolean isAccountExpired() {
		return accountExpired;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 * @return true if account is still active
	 */
	@Transient
	public boolean isAccountNonExpired() {
		return !isAccountExpired();
	}

	@Column(name = "account_locked", nullable = false)
	public boolean isAccountLocked() {
		return accountLocked;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 * @return false if account is locked
	 */
	@Transient
	public boolean isAccountNonLocked() {
		return !isAccountLocked();
	}

	@Column(name = "credentials_expired", nullable = false)
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 * @return true if credentials haven't expired
	 */
	@Transient
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}

	@Column(name = "create_user", length = 50, nullable = false, updatable = false)
	public String getCreateUser() {
		return createUser;
	}

	@Column(name = "create_date", nullable = false, updatable = false)
	public Timestamp getCreateDate() {
		return createDate;
	}

	@Column(name = "update_user", length = 50, nullable = false)
	public String getUpdateUser() {
		return updateUser;
	}

	@Column(name = "update_date", nullable = false)
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	
	public void setUserAuthorizedUrls(Collection<UserAuthority> userAuthorizedUrls) {
		this.userAuthorizedUrls = userAuthorizedUrls;
	}
	
	public void addUserAuthorizedUrl(UserAuthority userAuthorizedUrl) {
		if (this.userAuthorizedUrls == null) {
			this.userAuthorizedUrls = new ArrayList<UserAuthority>();
		}

		this.userAuthorizedUrls.add(userAuthorizedUrl);
	}

	public void setUserAuthorizedPlants(Collection<UserAuthority> userAuthorizedPlants) {
		this.userAuthorizedPlants = userAuthorizedPlants;
	}

	public void addUserAuthorizedPlant(UserAuthority userAuthorizedPlant) {
		if (this.userAuthorizedPlants == null) {
			this.userAuthorizedPlants = new ArrayList<UserAuthority>();
		}

		this.userAuthorizedPlants.add(userAuthorizedPlant);
	}

	public void setUserAuthorizedSuppliers(Collection<UserAuthority> userAuthorizedSuppliers) {
		this.userAuthorizedSuppliers = userAuthorizedSuppliers;
	}

	public void addUserAuthorizedSupplier(UserAuthority userAuthorizedSupplier) {
		if (this.userAuthorizedSuppliers == null) {
			this.userAuthorizedSuppliers = new ArrayList<UserAuthority>();
		}

		this.userAuthorizedSuppliers.add(userAuthorizedSupplier);
	}

	public void setUserAuthorizedButtons(Collection<UserAuthority> userAuthorizedButtons) {
		this.userAuthorizedButtons = userAuthorizedButtons;
	}

	public void addUserAuthorizedButton(UserAuthority userAuthorizedButton) {
		if (this.userAuthorizedButtons == null) {
			this.userAuthorizedButtons = new ArrayList<UserAuthority>();
		}

		this.userAuthorizedButtons.add(userAuthorizedButton);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}

		final User user = (User) o;

		return !(username != null ? !username.equals(user.getUsername()) : user.getUsername() != null);
	}

	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		return (username != null ? username.hashCode() : 0);
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("username", this.username)
				.append("enabled", this.enabled).append("accountExpired", this.accountExpired)
				.append("credentialsExpired", this.credentialsExpired).append("accountLocked", this.accountLocked);

		// if (roles != null) {
		// sb.append("Granted Authorities: ");
		//
		// int i = 0;
		// for (Role role : roles) {
		// if (i > 0) {
		// sb.append(", ");
		// }
		// sb.append(role.toString());
		// i++;
		// }
		// } else {
		// sb.append("No Granted Authorities");
		// }
		return sb.toString();
	}

	@Transient
	@JsonIgnore
	public Collection<UserMenu> getUserMenus() {
		return userMenus;
	}

	public void setUserMenus(List<UserMenu> userMenus) {
		this.userMenus = userMenus;
	}

}
