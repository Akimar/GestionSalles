-- quand un badge est pass�, le java appelle proc qui revoie bool ouvrir avec id, date, time, salle
-- requete qui cherche si y'a une resa faite par employe dans l'horaire / date ou etat autoris�
-- Si oui, inserer dans historique acc�s Identifiant salle, Salrie, datetime acces, et 1
-- sinon, pareil avec 0

DELIMITER // 

CREATE PROCEDURE `ProcStockPassageBadge` (IN IdSalariee INT, IN DateAcces DATE, IN HeureAcces TIME, IN IdSalle INT , OUT Ouvrir BOOLEAN) 
   BEGIN 
	
	 
	--A il le droit ?
	
	
	--Si oui 
	INSERT INTO historiqueacces(IdentifiantSalarie, IdentifiantSalle, DateAcces /*, OuiOuNon  */) VALUES 
	--Si non
	
	
   END//

DELIMITER ;