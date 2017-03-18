/**
 * Your application code goes here<br>
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */


package userclasses;

import generated.StateMachineBase;
import com.codename1.ui.*; 
import com.codename1.ui.events.*;
import com.codename1.ui.util.Resources;
import com.codename1.media.*;
import com.codename1.ui.Display;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {
    private Media media;
    
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
        try
        {
            this.media = 
                    MediaManager.createMedia(Display.getInstance().getResourceAsStream(getClass(), "/sound.mp3"), "audio/mp3");
        }
        catch(Exception ex)
        {
            
        }
    }


    @Override
    protected void onMain_PlayButtonAction(Component c, ActionEvent event) {
        if(media.isPlaying())
            media.pause();
        else
            media.play();
    }

    @Override
    protected void postMain(Form f) {
        media.setVolume(findVolumeSlider().getProgress());
        findVolumeSlider().addActionListener(e -> 
        {
            media.setVolume(findVolumeSlider().getProgress());
        });
    }
}
