package cl.everis.ccastillo.vo;

import java.io.Serializable;

public class Poeta implements Serializable	{
	
	private static final long serialVersionUID = -4342914376239657117L;
	private String name;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Poeta [name=" + name + ", url=" + url + "]";
	}
	
}
