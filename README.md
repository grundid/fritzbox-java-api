Java API für die FritzBox
======================================

Dieses Projekt enthält Klassen für den Zugriff auf die FritzBox.
Im Augenblick ist der Login und das Bearbeiten des WIFI Gastzugangs implementiert.

Beispiel:

	FritzTemplate fritzTemplate = new FritzTemplate(new RestTemplate(), "yourfritzpassword");
	fritzTemplate.activateGuestAccess("network-ssid", "wifi-wpa-key");

Weitere Funktionen können leicht nachimplementiert werden. Pull-Requests sind willkommen.
