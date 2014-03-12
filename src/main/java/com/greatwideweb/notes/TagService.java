/**
 * 
 */
package com.greatwideweb.notes;

import java.util.ArrayList;
import java.util.List;

import com.evernote.edam.type.Notebook;
import com.evernote.edam.type.Tag;

/**
 * @author dave
 *
 */
public class TagService extends EvernoteService
{
  public TagService()
  throws Exception
  {
    if(! isInit())
      throw new Exception("NotebookService cannot be initialized");
  }
  
  public ArrayList<TagVO> getTags(String arg)
  throws Exception
  {
    List<Tag> tags = noteStore.listTagsByNotebook(Application.authToken, arg);
    ArrayList<TagVO> result = new ArrayList<TagVO>();
    for(Tag t : tags)
    {
      TagVO vo = new TagVO();
      vo.guid = t.getGuid();
      vo.name = t.getName();
      vo.parentGuid = t.getParentGuid();
      result.add(vo);
    }
    return result;
  }
}
