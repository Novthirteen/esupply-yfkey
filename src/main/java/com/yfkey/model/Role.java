package com.yfkey.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


@Entity
@Table(name = "role")
public class Role extends BaseObject implements Serializable, Auditable, Versionable {
    private static final long serialVersionUID = 3690197650654049848L;
    private String code;
    private String name;
    private String createUser;
    private Timestamp createDate;
    private String updateUser;
    private Timestamp updateDate;
    private int version;
    
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Role() {
    }

    /**
     * Create a new instance and set the code.
     *
     * @param name code of the role.
     */
    public Role(final String code) {
        this.code = code;
    }

    @Id
    @Column(length = 20)
    public String getCode() {
        return code;
    }

    @Column(length = 50)
    public String getName() {
        return this.name;
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
    
    @Version
    public int getVersion() {
    	return version;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public void setVersion(int version) {
    	this.version = version;
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }

        final Role role = (Role) o;

        return !(code != null ? !code.equals(role.code) : role.code != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (code != null ? code.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.code)
                .toString();
    }
}
