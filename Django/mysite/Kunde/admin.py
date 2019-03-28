from django.contrib import admin

from .models import Lehrer, Fach, Klasse, Unterricht, Schueler, Note, Schunt, Nope, Einzelnote

admin.site.register(Lehrer)
admin.site.register(Schueler)
admin.site.register(Klasse)
admin.site.register(Fach)
admin.site.register(Unterricht)
admin.site.register(Note)
admin.site.register(Schunt)
admin.site.register(Nope)
admin.site.register(Einzelnote)