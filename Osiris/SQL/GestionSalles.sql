#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

CREATE DATABASE GestionSalles charset=utf8;
USE GestionSalles;
#------------------------------------------------------------
# Table: Salle
#------------------------------------------------------------

CREATE TABLE Salle(
        Identifiant SMALLINT Auto_increment  NOT NULL,
        NumeroTerminal VARCHAR(50),
        NomSalle       VARCHAR(50),
        NombrePortes   TINYINT,
        PRIMARY KEY (Identifiant))ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Salarié
#------------------------------------------------------------

CREATE TABLE Salarie(
        Identifiant SMALLINT Auto_increment  NOT NULL ,
        Nom         VARCHAR(50) ,
        Prenom      VARCHAR(50) ,
        Badge       VARCHAR(50) ,
        EstAdmin    Bool ,
        PRIMARY KEY (Identifiant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Jour
#------------------------------------------------------------

CREATE TABLE Jour(
        Identifiant TINYINT Auto_increment  NOT NULL,
        Jour VARCHAR(50) ,
        IdentifiantDisponibilite SMALLINT,
        PRIMARY KEY (Identifiant))ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Disponibilité
#------------------------------------------------------------

CREATE TABLE Disponibilite(
        Identifiant    SMALLINT Auto_increment  NOT NULL,
        HoraireDebMat  TIME,
        HoraireFinMat  TIME,
        HoraireDebSoir TIME,
        HoraireFinSoir TIME,
        PRIMARY KEY (Identifiant))ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Réservation
#------------------------------------------------------------

CREATE TABLE Reservation(
        Identifiant INT Auto_increment  NOT NULL,
        DateRes DATE,
        HoraireDeb TIME,
        HoraireFin  TIME,
        IdentifiantJour TINYINT,
        IdentifiantSalarie SMALLINT,
        IdentifiantSalle SMALLINT ,
        PRIMARY KEY (Identifiant))ENGINE=InnoDB;


#------------------------------------------------------------
# Table: schedule
#------------------------------------------------------------

CREATE TABLE Schedule(
        IdentifiantSalle SMALLINT NOT NULL ,
        IdentifiantJour TINYINT NOT NULL ,
        PRIMARY KEY (IdentifiantSalle, IdentifiantJour))ENGINE=InnoDB;


#------------------------------------------------------------
# Table: est_autorisé
#------------------------------------------------------------

CREATE TABLE Autorise(
        IdentifiantSalarie  SMALLINT NOT NULL,
        IdentifiantReservation INT NOT NULL ,
        PRIMARY KEY (IdentifiantSalarie ,IdentifiantReservation )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: trace
#------------------------------------------------------------

CREATE TABLE Trace(
        IdentifiantSalarie SMALLINT NOT NULL,
        IdentifiantSalle SMALLINT NOT NULL,
        DateTrace DATETIME NOT NULL,
        PRIMARY KEY (IdentifiantSalarie,IdentifiantSalle, DateTrace)
)ENGINE=InnoDB;

ALTER TABLE Jour ADD CONSTRAINT FK_Jour_Identifiant_Disponibilite FOREIGN KEY (IdentifiantDisponibilite) REFERENCES Disponibilite(Identifiant);
ALTER TABLE Reservation ADD CONSTRAINT FK_Reservation_Identifiant_Jour FOREIGN KEY (IdentifiantJour) REFERENCES Jour(Identifiant);
ALTER TABLE Reservation ADD CONSTRAINT FK_Reservation_Identifiant_Salarie FOREIGN KEY (IdentifiantSalarie) REFERENCES Salarie(Identifiant);
ALTER TABLE Reservation ADD CONSTRAINT FK_Reservation_Identifiant_Salle FOREIGN KEY (IdentifiantSalle) REFERENCES Salle(Identifiant);
ALTER TABLE Schedule ADD CONSTRAINT FK_Schedule_Identifiant_Salle FOREIGN KEY (IdentifiantSalle) REFERENCES Salle(Identifiant);
ALTER TABLE Schedule ADD CONSTRAINT FK_Schedule_Identifiant_Jour FOREIGN KEY (IdentifiantJour) REFERENCES Jour(Identifiant);
ALTER TABLE Autorise ADD CONSTRAINT FK_Autorise_Identifiant_Salarie FOREIGN KEY (IdentifiantSalarie) REFERENCES Salarie(Identifiant);
ALTER TABLE Autorise ADD CONSTRAINT FK_Autorise_Identifiant_Reservation FOREIGN KEY (IdentifiantReservation) REFERENCES Reservation(Identifiant);
ALTER TABLE Trace ADD CONSTRAINT FK_Trace_Identifiant_Salarie FOREIGN KEY (IdentifiantSalarie) REFERENCES Salarie(Identifiant);
ALTER TABLE Trace ADD CONSTRAINT FK_Trace_Identifiant_Salle FOREIGN KEY (IdentifiantSalle) REFERENCES Salle(Identifiant);
