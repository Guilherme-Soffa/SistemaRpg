import { ClasseDTO } from "./classe-dto";
import { RacaDTO } from "./raca-dto";

export interface FichaDTO{
  personagem?: string;
  classe?: ClasseDTO;
  raca?: RacaDTO;
  origem?: string;
  antecedente?: string;
}
