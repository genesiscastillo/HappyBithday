package cl.everis.ccastillo.vo;

public class Poema {

	private String title;
	private String content;
	private String url;
	public Poeta poet = new Poeta();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Poeta getPoet() {
		return poet;
	}

	public void setPoet(Poeta poet) {
		this.poet = poet;
	}

	@Override
	public String toString() {
		return "Poema [title=" + title + ", content=" + content + ", url=" + url + ", poet=" + poet + "]";
	}
	
}
