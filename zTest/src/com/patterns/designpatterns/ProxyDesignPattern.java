package com.patterns.designpatterns;

//Getting cash from Bank through the cheque or withdrawal token as proxy's
//Another example is like Hibernate's load() method.

interface Image {
	public void loadImage();
}

class RealImage implements Image {

	String imageUrl = null;

	public RealImage(String imageUrl) {
		this.imageUrl = imageUrl;
		loadFromDisk(imageUrl);
	}

	@Override
	public void loadImage() {
		System.out.println("Connected to RealImage" + imageUrl);
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Loading " + fileName);
	}
}

class ProxyImage implements Image {

	private Image realImage;
	private String imageUrl;

	public ProxyImage(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public void loadImage() {
		if (realImage == null) {
			realImage = new RealImage(imageUrl);
		}
		realImage.loadImage();
	}

}

public class ProxyDesignPattern {

	public static void main(String[] args) {
		Image image = new ProxyImage("imageFile.png");
		image.loadImage();

		// Here image is loaded into the proxy, so again it will not load from disk
		image.loadImage();
	}
}
