Feature: Agregar-Editar-Eliminar-Validar datos
  Scenario: Llenar formulario
    Given Indexar pagina
    When Llenar Formulario
    And Guardar Formulario
    Then Validar Llenado
    When Editar Formulario
    And Guardar cambios
    Then Validar cambios
    Then Eliminar Formulario

