export interface CapacitorRollbarPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
