import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@SuppressWarnings("serial")
public class OAuthUserProfile implements UserDetails{
	
	
	
	private final String userName;
	private final String user_name;
	private final Integer exp;
	private final String jti;



	public OAuthUserProfile(
			String user_name, String userName, Integer exp, String jti
			) {
		super();
		this.user_name = user_name;
		this.userName = userName;
		this.exp = exp;
		this.jti = jti;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return userName;
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
		return true;
	}

	
	public String getUser_name() {
		return user_name;
	}

	public Integer getExp() {
		return exp;
	}

	public String getJti() {
		return jti;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", exp=");
		builder.append(exp);
		builder.append(", userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}

	public static OAuthUserProfile fromUserInfoMap(Map<String, Object> map) {
		
		return new OAuthUserProfile(
				(String) map.get("user_name"),
				(String) map.get("user_name"),
				(Integer) map.get("exp"),
				(String) map.get("jti"))	;
	}

	
}
