/**
 * 
 */
package com.greatwideweb.notes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.notestore.NoteList;
import com.evernote.edam.type.Note;
import com.evernote.edam.type.Notebook;

/**
 * @author dave
 *
 */
public class TagNotesService extends EvernoteService
{

  public TagNotesService()
      throws Exception
      {
        if(! isInit())
          throw new Exception("TagNotesService cannot be initialized");
      }
      
      public ArrayList<NoteVO> getNotes(String arg)
      throws Exception
      {
        System.out.println("Argument: " + arg);
        NoteFilter filter  = new NoteFilter();
        filter.addToTagGuids(arg);
        NoteList noteList = noteStore.findNotes(Application.authToken, filter, 0, 10);
        ArrayList<NoteVO> result = new ArrayList<NoteVO>();
        for(Note n : noteList.getNotes())
        {
          NoteVO vo = new NoteVO();
          vo.guid = n.getGuid();
          vo.content = n.getContent();
          System.out.println("title: " +  n.getTitle() + " tags: " + n.getTagNames() + "  n.getTagNamesSize() :" +  n.getTagNamesSize());
          System.out.println("Tag UIDs: " + n.getTagGuids());
          Iterator<String> tags = n.getTagNamesIterator();
          if(tags == null)
            System.out.println("hes null");
          else
          {
            
            while(tags.hasNext())
            {
              System.out.println("Iterator tag: " + tags.next());
            }
            
          }
          
         
          vo.tags = (ArrayList<String>) n.getTagNames();
          vo.title = n.getTitle();    
          result.add(vo);
        }
        return result;
      }
}
