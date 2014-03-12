/**
 * 
 */
package com.greatwideweb.notes;


import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import com.evernote.edam.type.Notebook;

/**
 * @author dave
 *
 */
@Path("notebooks")
@XmlRootElement
public class NotebookService extends EvernoteService
{
  public NotebookService()
  throws Exception
  {
    if(! isInit())
      throw new Exception("NotebookService cannot be initialized");
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<NotebookVO> getNotebooks()
  throws Exception
  {
    List<Notebook> notebooks = noteStore.listNotebooks(Application.authToken);
    List<NotebookVO> result = new ArrayList<NotebookVO>();
    for(Notebook eNotebook : notebooks)
    {
      NotebookVO vo = new NotebookVO();
      vo.guid = eNotebook.getGuid();
      vo.name = eNotebook.getName();
      vo.isDefault = eNotebook.isDefaultNotebook();
      result.add(vo);
    }
    return result;
  }
  
  
  
}
