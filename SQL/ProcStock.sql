DROP PROCEDURE `ProcStockPassageBadge`;

DELIMITER // 
CREATE PROCEDURE `ProcStockPassageBadge` (IN IdSalarie INT, IN IdSalle INT ) 
   BEGIN 
	DECLARE fin TINYINT DEFAULT 0;
	DECLARE Ouvrir INT DEFAULT 0;
	
        SET Ouvrir = ( SELECT COUNT(Identifiant)
		FROM Reservation 
		INNER JOIN autorise ON autorise.IdentifiantReservation = Reservation.Identifiant
        WHERE Reservation.IdentifiantSalarie=IdSalarie OR Autorise.IdentifiantSalarie = Idsalarie AND DateRes = NOW() AND TIMESTAMPDIFF(MINUTE,NOW(), HoraireDeb) <= 0 AND TIMESTAMPDIFF(MINUTE,NOW(),HoraireFin) >= 0);
	
	IF Ouvrir = 0 THEN
	INSERT INTO historiqueacces(IdentifiantSalarie, IdentifiantSalle, DateAcces, Autorise) VALUES (IdSalarie, IdSalle, NOW(), 0);
	SELECT Ouvrir as Test;
	ELSE
	INSERT INTO historiqueacces(IdentifiantSalarie, IdentifiantSalle, DateAcces, Autorise) VALUES (IdSalarie, IdSalle, NOW(), 1);
	SELECT Ouvrir as Ouverture;
	END IF;
	
   END //

DELIMITER ;


