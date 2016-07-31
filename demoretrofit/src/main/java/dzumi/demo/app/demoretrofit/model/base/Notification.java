package dzumi.demo.app.demoretrofit.model.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

@SerializedName("id")
@Expose
private Long id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("content")
@Expose
private String content;

/**
* 
* @return
* The id
*/
public Long getId() {
return id;
}

/**
* 
* @param id
* The id
*/
public void setId(Long id) {
this.id = id;
}

/**
* 
* @return
* The title
*/
public String getTitle() {
return title;
}

/**
* 
* @param title
* The title
*/
public void setTitle(String title) {
this.title = title;
}

/**
* 
* @return
* The content
*/
public String getContent() {
return content;
}

/**
* 
* @param content
* The content
*/
public void setContent(String content) {
this.content = content;
}

}