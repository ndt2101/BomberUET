package uet.oop.bomberman.level;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio {

    Clip MenuMusic;
    int useless;


    public Audio(int num){
        useless = num;
    }

    public void playMenu(){
        try{
            AudioInputStream in1 = AudioSystem.getAudioInputStream(new File("res\\sound\\PUBGTheme-VA-5986478 (online-audio-converter.com).wav"));
            MenuMusic = AudioSystem.getClip();
            MenuMusic.open(in1);
            MenuMusic.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void stopMenu(){
        MenuMusic.stop();
    }


    public static void playEntinyDie(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("res\\sound\\Zombie In Pain-SoundBible.com-134322253.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playBombDrop(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("res\\sound\\bomdrop.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
            System.out.println(clip.getMicrosecondLength());
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playBombExplode(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("res\\sound\\bomb.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void playVictory(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("res\\sound\\Victory (mp3cut.net) (1).wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public void playGameSong(){

    }
    public static void bomberdie(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("res\\sound\\soundbomberdie.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }
    public static void eat(){
        try{
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("res\\sound\\eat.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();
        }
        catch(Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        Audio.playVictory();
        Thread.sleep(5000);
    }
}




