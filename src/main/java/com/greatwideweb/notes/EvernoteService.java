/**
 * 
 */
package com.greatwideweb.notes;

import com.evernote.edam.notestore.NoteStore;
import com.evernote.edam.userstore.UserStore;
import com.evernote.thrift.protocol.TBinaryProtocol;
import com.evernote.thrift.transport.THttpClient;

/**
 * @author dave
 *
 */
public class EvernoteService
{

  protected NoteStore.Client noteStore;
  protected String newNoteGuid;
  
  protected boolean isInit()
  throws Exception
  {
 // Set up the UserStore client and check that we can speak to the server
    THttpClient userStoreTrans = new THttpClient(Application.userStoreUrl);
    userStoreTrans.setCustomHeader("User-Agent", Application.userAgent);
    TBinaryProtocol userStoreProt = new TBinaryProtocol(userStoreTrans);
    UserStore.Client userStore = new UserStore.Client(userStoreProt, userStoreProt);

    boolean versionOk = userStore.checkVersion("Evernote EDAMDemo (Java)",
        com.evernote.edam.userstore.Constants.EDAM_VERSION_MAJOR,
        com.evernote.edam.userstore.Constants.EDAM_VERSION_MINOR);
    if (!versionOk) 
    {
      System.err.println("Incomatible Evernote client protocol version");
      return false;
    }
    
    // Get the URL used to interact with the contents of the user's account
    // When your application authenticates using OAuth, the NoteStore URL will
    // be returned along with the auth token in the final OAuth request.
    // In that case, you don't need to make this call.
    String notestoreUrl = userStore.getNoteStoreUrl(Application.authToken);
    
    // Set up the NoteStore client 
    THttpClient noteStoreTrans = new THttpClient(notestoreUrl);
    noteStoreTrans.setCustomHeader("User-Agent", Application.userAgent);
    TBinaryProtocol noteStoreProt = new TBinaryProtocol(noteStoreTrans);
    noteStore = new NoteStore.Client(noteStoreProt, noteStoreProt);
    
    return true;
  }
}
