import { Component, OnInit, ViewChild } from '@angular/core';
import { Hospital orderService } from './hospital order.service';





@Component({
  selector: 'app-hospital order',
  templateUrl: './hospital order.component.html',
  styleUrls: ['./hospital order.component.scss'],
})

export class Hospital orderComponent implements OnInit {
    columnDefs: any = [{ headerName: 'Order ', field: 'orderid'  },{ headerName: '', field: 'orderdate'  },{ headerName: 'Speciemen NO', field: 'specimen'  },{ headerName: 'patient ID ', field: 'patientid'  },{ headerName: '', field: 'facilityid'  },{ headerName: 'column_11', field: ''  },{ headerName: 'Episode Type', field: 'episodetype'  },{ headerName: '', field: 'episodeid'  },{ headerName: 'Doctor', field: 'doctor'  },{ headerName: 'type', field: 'code'  },{ headerName: 'code', field: 'pscode'  },];
    public hosptitalorders:any = {
        created_date: '',
        created_by: '',
        last_modified_by: '',
        last_modified_date: '',
        orderid: '',
        orderdate: '',
        specimen: '',
        patientid: '',
        facilityid: '',
        episodetype: '',
        episodeid: '',
        doctor: '',
        type: '',
        code: '',
        pscode: '',
    }
    paginationPageSize = 10;
 	page=1;
 	rowData: any[] = [];
 	rowIndex: Number = 0;




    constructor (
        private hospital orderService: Hospital orderService,
    ) { }

    ngOnInit() {
        this.hosptitalorders.created_by = sessionStorage.getItem('email') || ''; 
        


    
    }


}