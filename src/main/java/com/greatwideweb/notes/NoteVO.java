/**
 * 
 */
package com.greatwideweb.notes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author dave
 *
 */
public class NoteVO implements Serializable
{

  private static final long serialVersionUID = 1L;
  public String guid;
  public String title;
  public String content;
  public String notebookGuid;
  public ArrayList<String>tags;
  public boolean active;
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
    return "NoteVO [guid=" + guid + ", title=" + title + ", content=" + content
        + ", notebookGuid=" + notebookGuid + ", tags=" + tags + ", active="
        + active + "]";
  }
  
  
  
}
