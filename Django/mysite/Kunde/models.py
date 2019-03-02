import datetime

from django.db import models
from django.utils import timezone

class Lehrer(models.Model):
    Vorname = models.CharField(max_length=200)
    Nachname = models.CharField(max_length=200)

    def __str__(self):
        return self.Vorname
        return self.Nachname



class Fach(models.Model):
    Name = models.CharField(max_length=200)

    def __str__(self):
        return self.Name
        
class Klasse(models.Model):
    Name = models.CharField(max_length=200)
    
    def __str__(self):
        return self.Name

class Unterricht(models.Model):
    Lehrer = models.ForeignKey(Lehrer, on_delete=models.CASCADE)
    KlasseID = models.ForeignKey(Klasse, on_delete=models.CASCADE)
    FachID = models.ForeignKey(Fach, on_delete=models.CASCADE)
    
    def __str__(self):
        return self.Lehrer.Vorname
        return self.Lehrer.Nachname
        return self.Klasse.Name
        return self.Fach.Name

class Schueler(models.Model):
    Name = models.CharField(max_length=200)
    KlasseID = models.ForeignKey(Klasse, on_delete=models.CASCADE)
    Vorname = models.CharField(max_length=200)
    Nachname = models.CharField(max_length=200)

    def __str__(self):
        return self.Vorname
        return self.Nachname
        return self.Klasse.Name

class Note(models.Model):
    Vorname = models.CharField(max_length=200)
    Nachname = models.CharField(max_length=200)
    SchuelerID = models.ForeignKey(Schueler, on_delete=models.CASCADE)
    UnterrichtID = models.ForeignKey(Unterricht, on_delete=models.CASCADE)
    Note = models.IntegerField(default=0)

    def __str__(self):
        return self.Schueler.Vorname
        return self.schueler.Nachname
        return self.Unterricht.Fach.Name

class Pruefung(models.Model):
    NoteID = models.ForeignKey(Note, on_delete=models.CASCADE)
    Note = models.IntegerField(default=0)
    
    def __str__(self):
        return self.Note

class Test(models.Model):
    NoteID = models.ForeignKey(Note, on_delete=models.CASCADE)
    Note = models.IntegerField(default=0)
    
    def __str__(self):
        return self.Note

