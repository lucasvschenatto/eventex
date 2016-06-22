import {address} from "../address/address";

export class Participant {
    id: string;
    name: string;
    userId: string;
    nametag: string;
    nationality: string;
    gender: string;
    education: string;
    birth: string;
    homePhone: string;
    cellphone: string;
    professionId: string;
    organization: string;
    department: string;
    role: string;
    workPhone: string;
    workCellphone: string;
    workEmail: string;
    homeAddress: address;
    workAddress: address;
}
