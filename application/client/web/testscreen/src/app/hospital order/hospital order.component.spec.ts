import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Hospital orderComponent } from './hospital order.component';
import { Hospital orderService } from './hospital order.service'
import { of, throwError } from 'rxjs';
import { SharedService } from 'src/shared/shared.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClient } from '@angular/common/http';
import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Hospital orderComponent } from './hospital order.component';
import { NgbPaginationModule, NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';


describe('Hospital orderComponent', () => {
  let component: Hospital orderComponent;
  let fixture: ComponentFixture<Hospital orderComponent>;
  let service: Hospital orderService;
  let sharedServiceMock = jasmine.createSpyObj('SharedService', ['methodName1', 'methodName2']);
  let httpClient: HttpClientTestingModule;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, 
        FormsModule, ReactiveFormsModule,
        NgbPaginationModule,
      ],
      declarations: [ Hospital orderComponent ],
      providers: [ Hospital orderService, 
        { provide: SharedService, useValue: sharedServiceMock},
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Hospital orderComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(Hospital orderService);
    httpClient = TestBed.inject(HttpClient);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // ngOnInit application onload
  it('should set the created_by property with the value from sessionStorage', () => {
    const mockEmail = 'test@example.com';
    spyOn(sessionStorage, 'getItem').and.returnValue(mockEmail);
    component.ngOnInit();

    expect(sessionStorage.getItem).toHaveBeenCalledWith('email');
    expect(component.hosptitalorders.created_by).toEqual(mockEmail);

  });
  


});