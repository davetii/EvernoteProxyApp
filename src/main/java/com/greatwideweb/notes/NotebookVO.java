package com.greatwideweb.notes;

import java.io.Serializable;

public class NotebookVO
implements Serializable
{

  private static final long serialVersionUID = 1L;
  public String guid;
  public boolean isDefault;
  public String name;
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
    return "NotebookVO [guid=" + guid + ", isDefault=" + isDefault + ", name="
        + name + "]";
  }
  
  
  

}
