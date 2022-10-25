import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClasseDTO } from 'src/modules/classe-dto';
import { RacaDTO } from 'src/modules/raca-dto';
import { FichaService } from '../service/ficha.service';

interface item {
  value: string;
  label: string;
}

@Component({
  selector: 'app-ficha',
  templateUrl: './ficha.component.html',
  styleUrls: ['./ficha.component.scss']
})
export class FichaComponent implements OnInit {


	router: Router;
  racas: RacaDTO[] = [];
  classes: ClasseDTO[] = [];

  origem: item[] =[
    {value: '1', label: 'huaaaaaaaaaaaaaaaaamano B'},
    {value: '2', label: 'eqwe lua'},
    {value: '3', label: 'dd'},
  ]

  antecedente: item[] =[
    {value: '1', label: 'das B'},
    {value: '2', label: 'das lua'},
    {value: '3', label: 'ddd'},
  ]

  form: FormGroup;
  selected = 'option2';

  constructor(
    readonly formBuilder: FormBuilder,
    private fichaService: FichaService,
    router: Router,
  ) {
    this.router = router;
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      raca: [null, Validators.required],
      classe: [null, Validators.required],
      antecedente: [null, Validators.required],
      origem: [null, Validators.required],
    })

    this.fichaService.buscarRacaClasse().subscribe(r=>{
      this.racas = r.racas
      this.classes = r.classes
    });
  }

  submit(){
    console.log('teste',this.trataDados())
  }

  async voltar(){
    await this.router.navigate(["/acompanhamento"]);
  }

  trataDados(){
    const dados =  this.form.controls;

  }

  buscaOrigemAntecedente(event: any){
    console.log(event)
    let racaSelecionada: RacaDTO;
    let classeSelecionada: ClasseDTO;
    if(event.value == raca){
      racaSelecionada = event.value;
    }
    if(event.value == classe){
      classeSelecionada = event.value;
    }
    if(classeSelecionada != null && racaSelecionada != null){

    }//pensei em fazer assim, mas eu tbm pensei em divir para n desobedecer
    //aquela "regra" onde uma função nao deve fazer mais q uma coisa,
    // mas eu n sei como q eu faria essa busca em outro lugar
  }

}
