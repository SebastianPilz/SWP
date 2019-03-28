import datetime

from django.db import models
from django.utils import timezone
from django.contrib.auth.models import User

class Lehrer(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)

    def __str__(self):
        return self.user.last_name + ", " + self.user.first_name

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
    Klasse = models.ForeignKey(Klasse, on_delete=models.CASCADE)
    Fach = models.ForeignKey(Fach, on_delete=models.CASCADE)
    
    def __str__(self):
        return self.Lehrer.user.last_name + ", " + self.Klasse.Name+", "+self.Fach.Name

class Schueler(models.Model):
    Klasse = models.ForeignKey(Klasse, on_delete=models.CASCADE)
    user = models.ForeignKey(User, on_delete=models.CASCADE)

    def __str__(self):
        return self.user.first_name + ", " + self.user.last_name + ", " + self.Klasse.Name

class Schunt(models.Model):
    Unterricht = models.ForeignKey(Unterricht, on_delete=models.CASCADE)
    Schueler = models.ForeignKey(Schueler, on_delete=models.CASCADE)

class Note(models.Model):
    Schueler = models.ForeignKey(Schueler, on_delete=models.CASCADE)
    Unterricht = models.ForeignKey(Unterricht, on_delete=models.CASCADE)
    Note = models.IntegerField(default=0)

    def __str__(self):
        return self.Schueler.user.last_name + ", " + self.Schueler.user.first_name + ", " + self.Unterricht.Fach.Name

class Einzelnote(models.Model):
    Bezeichnung = models.CharField(max_length=200)
    Note = models.IntegerField(default=0)

    def __str__(self):
        return self.Bezeichnung

class Nope(models.Model):
    Note = models.ForeignKey(Note, on_delete=models.CASCADE)
    Einzelnote = models.ForeignKey(Einzelnote, on_delete=models.CASCADE)

    def __str__(self):
        return self.Note.Schueler.user.last_name + ", " + self.Note.Schueler.user.first_name

