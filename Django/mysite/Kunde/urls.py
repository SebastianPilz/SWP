from django.urls import path, include

from . import views

app_name = 'Kunde'
urlpatterns = [
    path('', views.index, name='index'),
    path('<int:pk>', views.LehrerUView.as_view(), name='Lehrer'),
    path('Lehrer/<int:pk>/AlleSchueler', views.AlleschuelerView.as_view(), name='AlleSchueler'),
    path('LehrerSchueler/<int:pk>', views.LSchuelerView.as_view(), name='LehrerSchueler'),
    path('Schueler/<int:pk>', views.SchuelerView.as_view(), name='Schueler'),
    path('LehrerSchueler/<int:pk>/AddENote',  views.AddENote, name="AddENote"),
    path('LehrerSchueler/<int:pk>/changeNote',  views.changeNote, name="changeNote")
]