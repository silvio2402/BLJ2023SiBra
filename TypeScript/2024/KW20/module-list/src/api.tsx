import { useQuery } from "@tanstack/react-query";
import { createContext, useContext } from "react";

type AuthData = {
  token_type: string;
  expires_in: number;
  ext_expires_in: number;
  access_token: string;
};

export async function authenticate() {
  const response = await fetch("https://www.modulbaukasten.ch/assets/auth.php");

  let data = await response.text();
  data = JSON.parse(data);
  const authData = JSON.parse(data) as AuthData;
  if (authData.token_type !== "Bearer")
    throw new Error("Unexpected token type");

  return authData.access_token;
}

type DynamicsCommon = Partial<{
  "@odata.etag": string;
  modifiedon: string;
  _owninguser_value: string;
  overriddencreatedon: string;
  _modifiedonbehalfby_value: string;
  statecode: number;
  versionnumber: number;
  utcconversiontimezonecode: string;
  _modifiedby_value: string;
  createdon: string;
  _owningbusinessunit_value: string;
  _createdby_value: string;
  statuscode: number | string;
  _owningteam_value: string;
  _ownerid_value: string;
  timezoneruleversionnumber: string;
}>;

export type Module = DynamicsCommon & {
  // "@odata.etag": string;
  beembk_modulnummer: string;
  // "_owningbusinessunit_value@OData.Community.Display.V1.FormattedValue": string;
  _owningbusinessunit_value: string;
  beembk_modultitel_fr: string;
  // "statuscode@OData.Community.Display.V1.FormattedValue": string;
  statuscode: string;
  beembk_objektbeschreibung_it: string;
  beembk_kompetenz_it: string;
  beembk_modulid: string;
  // "createdon@OData.Community.Display.V1.FormattedValue": string;
  createdon: string;
  beembk_pdfname_it: string;
  // "statecode@OData.Community.Display.V1.FormattedValue": string;
  statecode: string;
  // "overriddencreatedon@OData.Community.Display.V1.FormattedValue": string;
  overriddencreatedon: string | null;
  // "_ownerid_value@OData.Community.Display.V1.FormattedValue": string;
  _ownerid_value: string;
  beembk_modultitel: string;
  // "modifiedon@OData.Community.Display.V1.FormattedValue": string;
  modifiedon: string;
  // "versionnumber@OData.Community.Display.V1.FormattedValue": string;
  versionnumber: string;
  beembk_modultitel_it: string;
  beembk_objektbeschreibung_fr: string;
  // "_beembk_kompetenzfeld_value@OData.Community.Display.V1.FormattedValue": string;
  _beembk_kompetenzfeld_value: string;
  beembk_objektbeschreibung: string;
  // "timezoneruleversionnumber@OData.Community.Display.V1.FormattedValue": string;
  timezoneruleversionnumber: string | null;
  beembk_kompetenz_fr: string;
  // "beembk_version@OData.Community.Display.V1.FormattedValue": string;
  beembk_version: string;
  // "_modifiedby_value@OData.Community.Display.V1.FormattedValue": string;
  _modifiedby_value: string;
  // "_beembk_vorganger_value@OData.Community.Display.V1.FormattedValue": string;
  _beembk_vorganger_value: string | null;
  // "_createdby_value@OData.Community.Display.V1.FormattedValue": string;
  _createdby_value: string;
  _owninguser_value: string;
  beembk_pdfname_fr: string;
  beembk_pdfname_de: string;
  beembk_kompetenz: string;
  importsequencenumber: string | null;
  _modifiedonbehalfby_value: string | null;
  utcconversiontimezonecode: string | null;
  _createdonbehalfby_value: string | null;
  _owningteam_value: string | null;
};

export async function getModules(
  token: string,
  by: { abschluss?: string } = {}
) {
  const response = await fetch(
    `https://ictbb.crm17.dynamics.com/api/data/v9.1/beembk_moduls?${
      by.abschluss ? "&filter=" : ""
    }`, //?$filter=contains(beembk_modulnummer,'${id}')`,
    {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    }
  );

  console.log(response);

  let modulesData = await response.json();

  return modulesData.value as Module[];
}

export type Abschluss = DynamicsCommon & {
  // "@odata.etag": string;
  beembk_bezeichnung_fr: string | null;
  // "_owningbusinessunit_value@OData.Community.Display.V1.FormattedValue": string;
  _owningbusinessunit_value: string;
  // "beembk_abschlusstyp@OData.Community.Display.V1.FormattedValue": string;
  beembk_abschlusstyp: number;
  // "statecode@OData.Community.Display.V1.FormattedValue": string;
  statecode: number;
  // "statuscode@OData.Community.Display.V1.FormattedValue": string;
  statuscode: number;
  beembk_abschlussid: string;
  // "_createdby_value@OData.Community.Display.V1.FormattedValue": string;
  _createdby_value: string;
  // "beembk_jahrdesbildungserlasses@OData.Community.Display.V1.FormattedValue": string;
  beembk_jahrdesbildungserlasses: number;
  beembk_bezeichnung_it: string | null;
  beembk_abschlussname: string;
  // "versionnumber@OData.Community.Display.V1.FormattedValue": string;
  versionnumber: number;
  // "_ownerid_value@OData.Community.Display.V1.FormattedValue": string;
  _ownerid_value: string;
  // "modifiedon@OData.Community.Display.V1.FormattedValue": string;
  modifiedon: string;
  _owninguser_value: string;
  // "_modifiedby_value@OData.Community.Display.V1.FormattedValue": string;
  _modifiedby_value: string;
  // "beembk_region@OData.Community.Display.V1.FormattedValue": string;
  beembk_region: number;
  // "createdon@OData.Community.Display.V1.FormattedValue": string;
  createdon: string;
  overriddencreatedon: string | null;
  importsequencenumber: number | null;
  beembk_bezeichnung: string | null;
  _modifiedonbehalfby_value: string | null;
  utcconversiontimezonecode: number | null;
  _createdonbehalfby_value: string | null;
  _owningteam_value: string | null;
  timezoneruleversionnumber: number | null;
};

export interface Lernort {
  "@odata.etag": string;
  "modifiedon@OData.Community.Display.V1.FormattedValue": string;
  modifiedon: string;
  _owninguser_value: string;
  beembk_lernortname_fr: string;
  overriddencreatedon: string | null;
  importsequencenumber: number | null;
  _modifiedonbehalfby_value: string | null;
  "statecode@OData.Community.Display.V1.FormattedValue": string;
  statecode: number;
  beembk_lernortname_it: string;
  "versionnumber@OData.Community.Display.V1.FormattedValue": string;
  versionnumber: number;
  utcconversiontimezonecode: string | null;
  beembk_lernortid: string;
  _createdonbehalfby_value: string | null;
  "_modifiedby_value@OData.Community.Display.V1.FormattedValue": string;
  _modifiedby_value: string;
  "createdon@OData.Community.Display.V1.FormattedValue": string;
  createdon: string;
  "_owningbusinessunit_value@OData.Community.Display.V1.FormattedValue": string;
  _owningbusinessunit_value: string;
  "statuscode@OData.Community.Display.V1.FormattedValue": string;
  statuscode: number;
  beembk_lernortname: string;
  _owningteam_value: string | null;
  "_createdby_value@OData.Community.Display.V1.FormattedValue": string;
  _createdby_value: string;
  "_ownerid_value@OData.Community.Display.V1.FormattedValue": string;
  _ownerid_value: string;
  timezoneruleversionnumber: number | null;
}

export interface ModuleType {
  "@odata.etag": string;
  beembk_modultyp_it: string;
  "modifiedon@OData.Community.Display.V1.FormattedValue": string;
  modifiedon: string;
  _owninguser_value: string;
  overriddencreatedon: string | null;
  importsequencenumber: number | null;
  _modifiedonbehalfby_value: string | null;
  beembk_modultyp: string;
  "statecode@OData.Community.Display.V1.FormattedValue": string;
  statecode: number;
  "versionnumber@OData.Community.Display.V1.FormattedValue": string;
  versionnumber: number;
  utcconversiontimezonecode: string | null;
  _createdonbehalfby_value: string | null;
  "_modifiedby_value@OData.Community.Display.V1.FormattedValue": string;
  _modifiedby_value: string;
  "createdon@OData.Community.Display.V1.FormattedValue": string;
  createdon: string;
  "_owningbusinessunit_value@OData.Community.Display.V1.FormattedValue": string;
  _owningbusinessunit_value: string;
  "statuscode@OData.Community.Display.V1.FormattedValue": string;
  statuscode: number;
  _owningteam_value: string | null;
  beembk_modultypid: string;
  "_createdby_value@OData.Community.Display.V1.FormattedValue": string;
  _createdby_value: string;
  "_ownerid_value@OData.Community.Display.V1.FormattedValue": string;
  _ownerid_value: string;
  beembk_modultyp_fr: string;
  timezoneruleversionnumber: number | null;
}

export interface Level {
  "@odata.etag": string;
  "modifiedon@OData.Community.Display.V1.FormattedValue": string;
  modifiedon: string;
  _owninguser_value: string;
  beembk_levelname_it: string;
  overriddencreatedon: string | null;
  importsequencenumber: string;
  beembk_levelname: string;
  _modifiedonbehalfby_value: string;
  "statecode@OData.Community.Display.V1.FormattedValue": string;
  statecode: string;
  beembk_levelid: string;
  "versionnumber@OData.Community.Display.V1.FormattedValue": string;
  versionnumber: string;
  utcconversiontimezonecode: string;
  beembk_levelname_fr: string;
  _createdonbehalfby_value: string;
  "_modifiedby_value@OData.Community.Display.V1.FormattedValue": string;
  _modifiedby_value: string;
  "createdon@OData.Community.Display.V1.FormattedValue": string;
  createdon: string;
  "_owningbusinessunit_value@OData.Community.Display.V1.FormattedValue": string;
  _owningbusinessunit_value: string;
  "statuscode@OData.Community.Display.V1.FormattedValue": string;
  statuscode: string;
  _owningteam_value: string;
  "_createdby_value@OData.Community.Display.V1.FormattedValue": string;
  _createdby_value: string;
  "_ownerid_value@OData.Community.Display.V1.FormattedValue": string;
  _ownerid_value: string;
  timezoneruleversionnumber: string;
}

export interface ModuleMapping {
  "@odata.etag": string;
  "_beembk_abschluss_value@OData.Community.Display.V1.FormattedValue": string;
  _beembk_abschluss_value: string;
  "modifiedon@OData.Community.Display.V1.FormattedValue": string;
  modifiedon: string;
  _owninguser_value: string;
  beembk_modulmappingid: string;
  "_beembk_modul_value@OData.Community.Display.V1.FormattedValue": string;
  _beembk_modul_value: string;
  overriddencreatedon: string | null;
  "_beembk_modultyp_value@OData.Community.Display.V1.FormattedValue": string;
  _beembk_modultyp_value: string;
  importsequencenumber: string | null;
  "_beembk_level_value@OData.Community.Display.V1.FormattedValue": string;
  _beembk_level_value: string;
  _modifiedonbehalfby_value: string | null;
  "_beembk_lernort_value@OData.Community.Display.V1.FormattedValue": string;
  _beembk_lernort_value: string;
  "statecode@OData.Community.Display.V1.FormattedValue": string;
  statecode: number;
  "versionnumber@OData.Community.Display.V1.FormattedValue": string;
  versionnumber: number;
  utcconversiontimezonecode: string | null;
  _createdonbehalfby_value: string | null;
  "_modifiedby_value@OData.Community.Display.V1.FormattedValue": string;
  _modifiedby_value: string;
  "createdon@OData.Community.Display.V1.FormattedValue": string;
  createdon: string;
  "_owningbusinessunit_value@OData.Community.Display.V1.FormattedValue": string;
  _owningbusinessunit_value: string;
  "statuscode@OData.Community.Display.V1.FormattedValue": string;
  statuscode: number;
  beembk_mappingid: string;
  _owningteam_value: string | null;
  "_createdby_value@OData.Community.Display.V1.FormattedValue": string;
  _createdby_value: string;
  "_ownerid_value@OData.Community.Display.V1.FormattedValue": string;
  _ownerid_value: string;
  timezoneruleversionnumber: string | null;

  beembk_Lernort: Lernort;
  beembk_Modul: Module;
  beembk_Modultyp: ModuleType;
  beembk_Level: Level;
}

export async function getAllAbschlusses(token: string) {
  const response = await fetch(
    `https://ictbb.crm17.dynamics.com/api/data/v9.1/beembk_abschlusses`,
    {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    }
  );

  console.log(response);

  let abschlussesData = await response.json();

  return abschlussesData.value as Abschluss[];
}

// async function test() {
//   const token = await authenticate();
//   const modules = await getAllModules(token);
//   console.log(modules);
// }

// test();

const TokenContext = createContext<string | null>(null);

export function useToken() {
  const token = useContext(TokenContext);
  if (token === undefined) {
    throw new Error("useToken must be used within a TokenProvider");
  }
  return token;
}

export function TokenProvider({ children }: { children: React.ReactNode }) {
  const { data } = useQuery({
    queryKey: ["token"],
    queryFn: authenticate,
  });

  return (
    <TokenContext.Provider value={data ?? null}>
      {children}
    </TokenContext.Provider>
  );
}
