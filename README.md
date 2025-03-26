Reporte PL/SQL

CREATE OR REPLACE PROCEDURE get_pokemon_report (
    p_name IN VARCHAR2 DEFAULT NULL,
    p_type IN VARCHAR2 DEFAULT NULL,
    p_ability IN VARCHAR2 DEFAULT NULL,
    p_cursor OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_cursor FOR
        SELECT
            p.POK_ID,
            p.POK_NAME,
            p.POK_URL,
            COALESCE(types.types_list, 'N/A') AS types,
            COALESCE(abilities.abilities_list, 'N/A') AS abilities
        FROM POKEMON.TU_POKEMON p

        -- Unir con los tipos de Pokémon
        LEFT JOIN (
            SELECT pt.FK_POKEMON,
                   LISTAGG(t.TYP_NAME, ', ') WITHIN GROUP (ORDER BY t.TYP_NAME) AS types_list
            FROM POKEMON.TU_POKEMON_TYPE pt
            JOIN POKEMON.TU_TYPE t ON pt.FK_TYPE = t.TYP_ID
            GROUP BY pt.FK_POKEMON
        ) types ON types.FK_POKEMON = p.POK_ID

        -- Unir con las habilidades de Pokémon
        LEFT JOIN (
            SELECT pa.FK_POKEMON,
                   LISTAGG(a.ABI_NAME, ', ') WITHIN GROUP (ORDER BY a.ABI_NAME) AS abilities_list
            FROM POKEMON.TU_POKEMON_ABILITY pa
            JOIN POKEMON.TU_ABILITY a ON pa.FK_ABILITY = a.ABI_ID
            GROUP BY pa.FK_POKEMON
        ) abilities ON abilities.FK_POKEMON = p.POK_ID

        WHERE (p_name IS NULL OR LOWER(p.POK_NAME) LIKE '%' || LOWER(p_name) || '%')

        -- Filtrar por tipo de Pokémon
        AND (p_type IS NULL OR EXISTS (
            SELECT 1
            FROM POKEMON.TU_POKEMON_TYPE pt
            JOIN POKEMON.TU_TYPE t ON pt.FK_TYPE = t.TYP_ID
            WHERE pt.FK_POKEMON = p.POK_ID
              AND LOWER(t.TYP_NAME) LIKE '%' || LOWER(p_type) || '%'
        ))

        -- Filtrar por habilidad de Pokémon
        AND (p_ability IS NULL OR EXISTS (
            SELECT 1
            FROM POKEMON.TU_POKEMON_ABILITY pa
            JOIN POKEMON.TU_ABILITY a ON pa.FK_ABILITY = a.ABI_ID
            WHERE pa.FK_POKEMON = p.POK_ID
              AND LOWER(a.ABI_NAME) LIKE '%' || LOWER(p_ability) || '%'
        ));
END;

Antes de crear este procedimiento se debe ejecutar el codigo, para que se cree el modelo. 
