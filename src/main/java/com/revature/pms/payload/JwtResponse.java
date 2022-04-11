package com.revature.pms.payload;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {
	private String accessToken;
	private String type = "Bearer";
	  private Integer id;
	  private String username;
	  private List<String> roles;

    public JwtResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    public JwtResponse(String accessToken, Integer id, String username,  List<String> roles) {
        this.accessToken = accessToken;
        this.id = id;
        this.username = username;
        this.roles = roles;
      }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}