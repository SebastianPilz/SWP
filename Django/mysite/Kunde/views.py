from django.http import HttpResponseRedirect
from django.shortcuts import get_object_or_404, render
from django.urls import reverse
from django.views import generic
from django.utils import timezone
from django.contrib.auth.mixins import LoginRequiredMixin
from django.contrib.auth.decorators import login_required

from .models import Lehrer, Fach, Klasse, Unterricht, Schueler, Note, Schunt, Nope


@login_required
def index(request):
    if Schueler.objects.filter(user=request.user).count() > 0:
        return HttpResponseRedirect(reverse('Kunde:Schueler', args=(Schueler.objects.get(user = request.user).pk,)))
    elif Lehrer.objects.filter(user=request.user).count() > 0:
        return HttpResponseRedirect(reverse('Kunde:Lehrer', args=(Lehrer.objects.get(user = request.user).pk,)))

class LehrerIndexView(generic.ListView):
    template_name = 'Kunde/Lehrerindex.html'
    context_object_name = 'list1'

    def get_queryset(self):
        return Lehrer.objects.filter()

class LehrerUView(generic.ListView):
    model = Unterricht
    template_name = 'Kunde/Lehrer.html'
    context_object_name = 'list2'

    def get_queryset(self):
        pk = self.kwargs['pk']
        l = []
        for i in Unterricht.objects.all():
            if(i.Lehrer.id == pk):
                l.append(i)
        return l

class AlleschuelerView(generic.ListView):
    template_name = 'Kunde/Alleschueler.html'
    context_object_name = 'list3'

    def get_queryset(self):
        pk = self.kwargs['pk']
        s = []
        for j in Unterricht.objects.all():
            if (pk == j.id):
                for i in Schunt.objects.all():
                    if (j.Klasse == i.Unterricht.Klasse):
                        s.append(i)
        return s

class LSchuelerView(generic.ListView):
    model = Note
    template_name = 'Kunde/LSchueler.html'
    context_object_name = 'list4'

    def get_queryset(self):
        pk = self.kwargs['pk']
        s = []
        for i in Schunt.objects.all():
            if (pk == i.id):
                for j in Nope.objects.all():
                    if (i.Schueler.id == j.Note.Schueler.id):
                        if (i.Unterricht.id == j.Note.Unterricht.id):
                            s.append(j)
        return s





class SchuelerIndexView(generic.ListView):
    template_name = 'Kunde/Schuelerindex.html'
    context_object_name = 'list100'

    def get_queryset(self):
        return Schueler.objects.filter()

class SchuelerView(generic.ListView):
    model = Note
    template_name = 'Kunde/Schueler.html'
    context_object_name = 'list101'

    def get_queryset(self):
        pk = self.kwargs['pk']
        n = []
        for i in Note.objects.all():
            if (pk == i.Schueler.id):
                n.append(i)
        return n

def changeNote(request):
    data = request.POST.copy()
    note = data.get('Note')


def addENote(request):
    data = request.POST.copy()
    string = data.get('bezeichnung')
    note = data.get('Note')
    Nope = Nope()