/**
 * 
 */
package com.greatwideweb.notes;

import java.io.Serializable;

/**
 * @author dave
 *
 */
public class TagVO
implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String name;
  public String guid;
  public String parentGuid;
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
  {
    return "TagVO [name=" + name + ", guid=" + guid + ", parentGuid="
        + parentGuid + "]";
  }
  
 
  
}
