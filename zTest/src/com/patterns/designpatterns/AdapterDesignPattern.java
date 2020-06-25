package com.patterns.designpatterns;
//Other Ex: Card Reader/Adapter between MemoryCard & Laptop to exchange data

interface MediaPlayer {
    public void play(String audioType, String fileName);
}

interface MediaPlayerType {
    public void playVlc(String fileName);

    public void playMp4(String fileName);
}

class VlcPlayer implements MediaPlayerType {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }
}

class Mp4Player implements MediaPlayerType {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }
}

//connecting class between two interfaces
class MediaAdapter implements MediaPlayer {

    MediaPlayerType mediaPlayerType;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            mediaPlayerType = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mediaPlayerType = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            mediaPlayerType.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mediaPlayerType.playMp4(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer {
    
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        // inbuilt support to play mp3 music files
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        // mediaAdapter is providing support to play other file formats
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

public class AdapterDesignPattern {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
